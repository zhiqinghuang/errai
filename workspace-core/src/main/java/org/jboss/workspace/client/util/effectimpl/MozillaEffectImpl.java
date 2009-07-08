package org.jboss.workspace.client.util.effectimpl;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import org.jboss.workspace.client.util.Effect;


public class MozillaEffectImpl implements Effect {
    public void doFade(final Element el, int durationMillis, final int stepping, final int start, final int end) {
        Timer t = start < end ?
                new Timer() {
                    int step = start;

                    public void run() {
                        step += stepping;
                        if (step < end) {
                            setOpacity(el, step);
                        }
                        else {
                            setOpacity(el, end);
                            cancel();
                        }
                    }
                }
                :
                new Timer() {
                    int step = end;

                    public void run() {
                        step -= stepping;
                        if (step > end) {
                            setOpacity(el, step);
                        }
                        else {
                            setOpacity(el, end);
                            cancel();
                        }
                    }
                };

        t.scheduleRepeating(durationMillis);
    }

    public void setOpacity(Element el, int opacity) {
        setOpacityNative(el.getStyle(), opacity);
    }

    public native static void setOpacityNative(Style s, int opacity) /*-{
        s.MozOpacity = opacity / 100;
    }-*/;
}
