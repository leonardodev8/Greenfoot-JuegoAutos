import greenfoot.*;

/**
 * Proyecto Auto
 * 
 * @author Leonardo Buleje
 * @version version 1.0
 */
public class MyWorld extends World
{
    // Instancia de la clase Score
    private score score;
    private score level;
    
    // Declarar variables globales - private
    private int velocidad_auto;
    private int numero_adelantamientos;
    private int numero_adelantamientos_nivel;
    private int numero_rivales;
    private AutoNaranja autonaranja;
    
    
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        
        // Inicializar valores al empezar el juego
        numero_adelantamientos = 0;
        numero_adelantamientos_nivel = 4;
        velocidad_auto = 2;
        
        // Inicializar marcadores
        score = new score("Score: ");
        level = new score("Level: ");
        level.add(1);
        
        // Agregar un Auto Naranja (instancia)
        autonaranja = new AutoNaranja(velocidad_auto);
        addObject(autonaranja, 300, 550);
        
        // Agregar score en el mundo
        addObject(level, 205, 90);
        addObject(score, 205, 60);
        
        // Agregar dos Autos Rojos (instancia)
        // AutoRojo autorojo1 = new AutoRojo(2);
        // addObject(autorojo1, 180, 50);
        
        // AutoRojo autorojo2 = new AutoRojo(3);
        // addObject(autorojo2, 420, 50);
        
    }
    
    // presiono boton ACT / RUN
    public void act(){
        aumentar_dificultad();
        agregar_rivales();
    }
    
    // aumentar el numero de adelantamientos
    public void aumentar_num_adelantamientos(){
        numero_adelantamientos++;
    }
    
    // aumentar puntuacion score
    public void aumentar_puntuacion(int valor){
        score.add(valor);
    }
    
    // subir dificultad del juego
    public void aumentar_dificultad(){
        // validar si el numero de autos que adelanto es igual al numero que 
        // corresponde para subir de nivel
        if( numero_adelantamientos == numero_adelantamientos_nivel){
            numero_adelantamientos = 0;
            numero_adelantamientos_nivel += 2;
            velocidad_auto++;
            autonaranja.aumentar_velocidad();
            level.add(1);
        }
    }
    
    // agregar los rivales de manera dinamica
    public void agregar_rivales(){
        // validar el numero de rivales para poder agregarlos al escenario
        if( numero_rivales == 0 ){
            // Generar numero aleatorio
            int carril = Greenfoot.getRandomNumber(3);
            
            if(carril == 0){
                AutoRojo autorojo = new AutoRojo(velocidad_auto);
                addObject(autorojo, 180, 50);
            }
            else if(carril == 1){
                AutoRojo autorojo = new AutoRojo(velocidad_auto);
                addObject(autorojo, 300, 50);
            }
            else{
                AutoRojo autorojo = new AutoRojo(velocidad_auto);
                addObject(autorojo, 420, 50);
            }
            
            carril++;
            carril = carril % 3;
               
            if(carril == 0){
                AutoRojo autorojo = new AutoRojo(velocidad_auto);
                addObject(autorojo, 180, 50);
            }
            else if(carril == 1){
                AutoRojo autorojo = new AutoRojo(velocidad_auto);
                addObject(autorojo, 300, 50);
            }
            else{
                AutoRojo autorojo = new AutoRojo(velocidad_auto);
                addObject(autorojo, 420, 50);
            }
            
            numero_rivales = 2;
            
        }
    }
    
    // eliminar rival
    public void eliminar_numero_rivales(){
        numero_rivales--;        
    }
}
