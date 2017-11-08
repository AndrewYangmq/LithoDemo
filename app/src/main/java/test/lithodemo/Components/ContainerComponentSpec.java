package test.lithodemo.Components;

import android.util.SparseArray;
import android.view.View;

import com.facebook.litho.Column;
import com.facebook.litho.ColumnReverse;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentLayout;
import com.facebook.litho.Row;
import com.facebook.litho.RowReverse;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.sections.Children;
import com.facebook.litho.sections.SectionContext;
import com.facebook.litho.sections.annotations.GroupSectionSpec;
import com.facebook.litho.sections.annotations.OnCreateChildren;
import com.facebook.litho.sections.common.DataDiffSection;
import com.facebook.litho.widget.Recycler;
import com.facebook.litho.widget.RecyclerBinder;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaWrap;

import java.util.List;

//@GroupSectionSpec
@LayoutSpec
public class ContainerComponentSpec {

//    @OnCreateChildren
//    Children onCreateChildren(
//            SectionContext c
////            @Prop ImmutableList<MyModel> dataModel
//    ) {
//        return Children.create()
//                .child(DataDiffSection.create(c))
//                .build();
//    }

    @OnCreateLayout
    static ComponentLayout onCreateLayout(
            ComponentContext c,
            @Prop FlexSetting f,
            @Prop List<Component> childComponents
//            @Prop RecyclerBinder binder
            ) {
        int direction = f.flexDirection;
        SparseArray<ComponentLayout.ContainerBuilder> map = new SparseArray<>();
        map.append(YogaFlexDirection.ROW.intValue(), Row.create(c));
        map.append(YogaFlexDirection.COLUMN.intValue(), Column.create(c));
        map.append(YogaFlexDirection.ROW_REVERSE.intValue(), RowReverse.create(c));
        map.append(YogaFlexDirection.COLUMN_REVERSE.intValue(), ColumnReverse.create(c));
        ComponentLayout.ContainerBuilder  builder = map.indexOfKey(direction) >= 0? map.get(direction) : Row.create(c);
        builder.flexGrow(f.flexGrow).flexShrink(f.flexShrink);
        if (f.flexBasis > 0){
            builder.flexBasisDip(f.flexBasis);
        }
        if (f.flexBasisPercent > 0){
            builder.flexBasisPercent(f.flexBasisPercent);
        }
        if(f.maxWidth > 0){
            builder.maxWidthDip(f.maxWidth);
        }
        if (f.flexWrap > 0) {
            builder.wrap(YogaWrap.fromInt(f.flexWrap));
        }
        if (f.alignItems > 0){
            builder.alignItems(YogaAlign.fromInt(f.alignItems));
        }
        for (Component cp : childComponents) {
            builder.child(cp);
        }
        return builder.build();
        //return builder.child(getRecyclerComponent(c, binder)).build();
    }

    private static Component<Recycler> getRecyclerComponent(ComponentContext c, RecyclerBinder binder) {
        return Recycler.create(c)
                .binder(binder).build();
    }
}
