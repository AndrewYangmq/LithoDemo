package test.lithodemo.Components;


import android.icu.text.SimpleDateFormat;
import android.view.View;
import android.widget.Toast;

import com.facebook.litho.ClickEvent;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentLayout;
import com.facebook.litho.EventHandler;
import com.facebook.litho.Row;
import com.facebook.litho.StateValue;
import com.facebook.litho.annotations.FromEvent;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.OnEvent;
import com.facebook.litho.annotations.OnUpdateState;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.annotations.State;
import com.facebook.litho.widget.EditText;
import com.facebook.litho.widget.Image;

import java.util.Calendar;

import test.lithodemo.R;


@LayoutSpec
public class DateComponentSpec {
    @OnCreateLayout
    static ComponentLayout onCreateLayout(
            ComponentContext c,
            @State String editTextValue
            ){
        return Row.create(c)
                .child(EditText.create(c).textSizeDip(14).flexGrow(1).editable(false).text(editTextValue))
                .child(Image.create(c)
                        .drawableRes(R.drawable.calendar)
                        .clickHandler(DateComponent.onCalendarClick(c))
                )
                .build();
    }

    @OnUpdateState
    static void updateEditTextState(StateValue<String> editTextValue) {
        String todayDate = new SimpleDateFormat("dd-MMM-yyyy").format(android.icu.util.Calendar.getInstance().getTime());
        editTextValue.set(todayDate);
    }

    @OnEvent(ClickEvent.class)
    static void onCalendarClick(ComponentContext c){
// At runtime, all component instances of a certain type share the same ComponentLifecycle reference.
// This means that there will only be one spec instance per component type, not per component instance.
        DateComponent.updateEditTextStateAsync(c);
//        Toast.makeText(c, "test!", Toast.LENGTH_LONG).show();
    }}
