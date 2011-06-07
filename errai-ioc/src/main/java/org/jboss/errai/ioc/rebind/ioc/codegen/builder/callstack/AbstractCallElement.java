package org.jboss.errai.ioc.rebind.ioc.codegen.builder.callstack;

import org.jboss.errai.ioc.rebind.ioc.codegen.Context;
import org.jboss.errai.ioc.rebind.ioc.codegen.Statement;
import org.jboss.errai.ioc.rebind.ioc.codegen.meta.MetaClass;

/**
 * @author Mike Brock <cbrock@redhat.com>
 */
public abstract class AbstractCallElement implements CallElement {
    protected CallElement next;
    protected MetaClass resultType = null;

    public void nextOrReturn(CallWriter writer, Context ctx, Statement statement) {
        if (statement != null) {
            if (!writer.getCallString().isEmpty()) {
                writer.append(".");
            }
            writer.append(statement.generate(ctx));
            resultType = statement.getType();
        }

        if (next != null) {
            getNext().handleCall(writer, ctx, statement);
        }
    }

    public void setNext(CallElement next) {
        this.next = next;
    }

    public CallElement getNext() {
        return next;
    }

    public static void append(CallElement start, CallElement last) {
        CallElement el = start;
        while (el.getNext() != null) el = el.getNext();

        el.setNext(last);
    }

    public MetaClass getResultType() {
        return resultType;
    }
}
