package yahtzee.buttonlistener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ButtonListener extends MouseAdapter {
	
	private Object myController;
	private Method myMethod;
	private Object[] myArguments;
	
	
	public ButtonListener( Object controller, Method method, Object[] args)
	{
		myController = controller;
		myMethod = method;
		myArguments = args;
	}
	
	public void mouseReleased(MouseEvent event)
	{
		Method method;
		Object controller;
		Object[] arguments;
		
		method = this.getMethod();
		controller = this.getController();
		arguments = this.getArguments();
		
		try 
		{
			method.invoke(controller, arguments);
		} 
		catch (IllegalAccessException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IllegalArgumentException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (InvocationTargetException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	protected Method getMethod()
    {
        return myMethod;
    }

    protected void setMethod(Method method)
    {
        myMethod = method;
    }

    protected Object getController()
    {
        return myController;
    }
      
    protected void setController(Object controller)
    {
      myController = controller;
    }
    
    protected Object[] getArguments()
    {
        return myArguments;
    }
    
    protected void setArguments(Object[] arguments)
    {
        myArguments = arguments;
    }
}
