package ml.volder.unikapi.event;

import ml.volder.unikapi.utils.ReflectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class EventManager {
    public static boolean callEvent(Event event){
        for (Handler handler : event.getHandlerList()) {
            try{
                if(event.getEventType() == handler.getEventType() && event.getClass().equals(handler.getEvent())){
                    handler.getMethod().invoke(handler.getInstance(), event);
                }
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return Cancellable.class.isAssignableFrom(event.getClass()) && ((Cancellable) event).isCancelled();
    }

    public static void registerEvents(Listener listener){
        List<Method> eventHandlerMethods = ReflectionUtils.getMethodsAnnotatedWith(listener.getClass(), EventHandler.class);
        for (Method method : eventHandlerMethods) {
            if(method.getParameterCount() == 1 && ReflectionUtils.isSuperClass(method.getParameterTypes()[0], Event.class)){
                Handler handler = new Handler(method, listener, method.getAnnotation(EventHandler.class).eventType(), (Class<? extends Event>) method.getParameterTypes()[0]);
                try{
                    Method registerEvent = method.getParameterTypes()[0].getMethod("registerEvent");
                    registerEvent.invoke(null);
                    Method getHandlersMethod = method.getParameterTypes()[0].getMethod("getHandlers");
                    List<Handler> handlerList = (List<Handler>) getHandlersMethod.invoke(null);
                    if(handlerList != null)
                        handlerList.add(handler);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
