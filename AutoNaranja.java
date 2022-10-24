import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Proyecto Auto
 * 
 * @author Leonardo Buleje
 * @version version 1.0
 */
public class AutoNaranja extends Actor
{
    // Crear variable global - privada
    private int velocidad;
    
    // Crear metodo constructor
    public AutoNaranja( int numvelocidad ){
        velocidad = numvelocidad;
    }
    
    /**
     * Act - do whatever the AutoNaranja wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Validar si el usuario presiona alguna tecla direccional.
        if(Greenfoot.isKeyDown("up")){
            if(getY() > 150){
                setLocation(getX(), getY() - velocidad);
            }
        }
        else if(Greenfoot.isKeyDown("down")){
            if(getY() < 540){
                setLocation(getX(), getY() + velocidad);
            }
        }
        else if(Greenfoot.isKeyDown("left")){
            if(getX() > 140){
                setLocation(getX() - velocidad, getY());
            }
        }
        else if(Greenfoot.isKeyDown("right")){
            if(getX() < 460){
                setLocation(getX() + velocidad, getY());
            }
        }
    }
    
    // Metodo para aumentar la velocidad de este auto
    public void aumentar_velocidad(){
        velocidad++;
    }
}
