package test.lithodemo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;
import com.facebook.litho.widget.LinearLayoutInfo;
import com.facebook.litho.widget.RecyclerBinder;
import com.facebook.litho.widget.Text;
import com.facebook.yoga.YogaEdge;

import java.util.Arrays;
import java.util.List;

public class LithoActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ComponentContext componentContext = new ComponentContext(this);
        createTestViews(conetentViewGroup, componentContext);
    }

    private void createTestViews(ViewGroup viewGroup, final ComponentContext componentContext){
        final Component component = Text.create(componentContext)
                .text("Hello World")
                .textSizeDip(50)
                .textColor(Color.RED)
                .paddingDip(YogaEdge.ALL, 5)
                .marginDip(YogaEdge.ALL, 5)
                .build();
        for (int i = 0; i < 10; i++) {
            LithoView lithoView = LithoView.create(this, component);
            viewGroup.addView(lithoView);
        }
    }
}
