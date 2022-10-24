import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Proyecto Auto
 * 
 * @author Leonardo Buleje
 * @version version 1.0
 */
public class score extends Actor
{
    private int value = 0;
    private int target = 0;
    private String text;
    private int stringLength;
    
    public score(String prefix){
        // Asingar a la variable global el parametro
        text = prefix;
        // Agregamos un tamaño para que se muestre el texto en el mundo
        stringLength = (text.length() + 2) * 16;
        
        // Creamos una imagen apartir del texto
        setImage(new GreenfootImage(stringLength, 24));
        GreenfootImage image = getImage();
        Font font = image.getFont();
        image.setFont(font.deriveFont(24.0F));  
        image.setColor(Color.BLACK);
        
        // Actualizamos la imagen
        updateImage();
    }
    
    // Método principal
    public void act()
    {
        if(value < target){
            value++;
            updateImage();
        }else if(value > target){
            value--;
            updateImage();
        }
    }
    
    public void add(int score){
        target += score;
    }
    
    public void substract(int score){
        target -= score;
    }
    
    public int getValue(){
        return value;
    }
    
    private void updateImage(){
        // Actualizamos la imagen conforme se va avanzando de nivel
        GreenfootImage image = getImage();
        image.clear();
        image.drawString(text + value, 1, 18);
    }
}
