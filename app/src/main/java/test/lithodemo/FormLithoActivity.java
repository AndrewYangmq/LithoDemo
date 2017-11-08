package test.lithodemo;

import android.os.Bundle;
import android.view.ViewGroup;

import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentLayout;
import com.facebook.litho.LithoView;
import com.facebook.litho.widget.EditText;
import com.facebook.litho.widget.RecyclerBinder;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaWrap;

import java.util.ArrayList;
import java.util.List;

import test.lithodemo.Components.ContainerComponent;
import test.lithodemo.Components.DateComponent;
import test.lithodemo.Components.FieldComponent;
import test.lithodemo.Components.FlexSetting;

public class FormLithoActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ComponentContext componentContext = new ComponentContext(this);
        createForm(componentContext);
    }
    private Component createChildContainer(final ComponentContext c, final Component editorComponent, int s, int e){
        FlexSetting f2 = new FlexSetting();
        f2.flexDirection = YogaFlexDirection.COLUMN.intValue();
        f2.maxWidth = 400;
        f2.flexGrow = 4;
        f2.flexShrink = 4;
        f2.flexBasis = 256;
        List<Component> childFields = new ArrayList<>();
        for (int i = s; i<= e; i++) {
            childFields.add(FieldComponent.create(c).label("Field" + i).editorComponent(editorComponent).build());
        }
        return ContainerComponent.create(c).f(f2).childComponents(childFields).build();
    }
    private void createForm(final ComponentContext c) {
        List<Component> childContainer = new ArrayList<>();
        childContainer.add(createChildContainer(c, EditText.create(c).textSizeDip(14).widthPercent(100).build(), 1, 5));
        final Component datePicker = DateComponent.create(c).build();
        childContainer.add(createChildContainer(c, datePicker,6, 0));
        FlexSetting f1 = new FlexSetting();
        f1.flexDirection = YogaFlexDirection.ROW.intValue();
        f1.flexWrap = YogaWrap.WRAP.intValue();
        f1.alignItems = YogaAlign.FLEX_START.intValue();
        final Component c1 = ContainerComponent.create(c).f(f1).childComponents(childContainer).build();
        LithoView lithoView = LithoView.create(this, c1);
        conetentViewGroup.addView(lithoView);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)lithoView.getLayoutParams();
        marginLayoutParams.setMargins(10,15,10,15);
    }
}
