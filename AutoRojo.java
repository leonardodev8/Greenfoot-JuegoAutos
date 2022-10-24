import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Proyecto Auto
 * 
 * @author Leonardo Buleje
 * @version version 1.0
 */
public class AutoRojo extends Actor
{
    // variable global
    private int velocidad;
    
    // Crear mi metodo constructor
    public AutoRojo( int numvelocidad ){
        velocidad = numvelocidad;
    }
    
    // Método principal
    public void act()
    {
        // Mover hacia abajo
        setLocation(getX(), getY() + velocidad);
        
        // validar si el objeto llego al final del escenario
        if(getY() >= getWorld().getHeight() - 1){
            MyWorld escenario = (MyWorld) getWorld();
            
            // Eliminar el AutoRojo
            escenario.removeObject(this);
            escenario.aumentar_num_adelantamientos();
            escenario.eliminar_numero_rivales();
            escenario.aumentar_puntuacion(5);
        }
        // Validar si el AutoRojo choca con el AutoNaranja
        else if( isTouching(AutoNaranja.class) ){
            // Parar el juego / programa
            Greenfoot.stop();
        }
    }
}
