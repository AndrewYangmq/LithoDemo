package test.lithodemo.Components;

import android.graphics.Color;

import com.facebook.litho.Border;
import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentLayout;
import com.facebook.litho.Row;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.widget.EditText;
import com.facebook.litho.widget.Text;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaEdge;

@LayoutSpec
public class FieldComponentSpec {
    @OnCreateLayout
    static ComponentLayout onCreateLayout(
            ComponentContext c,
            @Prop String label,
            @Prop Component editorComponent) {
        return Column.create(c)
                .marginDip(YogaEdge.ALL, 6)
                .alignItems(YogaAlign.FLEX_START)
                .flexGrow(1)
                .child(Text.create(c).text(label).textSizeDip(14))
                .child(editorComponent)
                .border(Border.create(c)
                        .color(YogaEdge.ALL, Color.BLACK)
                        .widthDip(YogaEdge.ALL, 1)
                        .cornerEffect(10)
                        .build())
                .build();
    }
}
