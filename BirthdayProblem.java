//Este programa determina si el 'Problema de Cumpleaños' es correcto o no (sí, lo es)
//El programa genera 100.000 cumpleaños posibles y selecciona una cierta cantidad (la variable 'participants') de ellos
//Pues calcula si cualquier dos de esos 'participants' cumpleaños son iguales
//Si hay 70 participantes, el numero de fracasos debería ser 0.01%
//Si hay 23 participantes, el numero de fracasos debería ser 50%
//El problema en cuestión: http://es.wikipedia.org/wiki/Paradoja_del_cumplea%C3%B1os



package birthdayproblem;

import java.util.Random;


public class BirthdayProblem {
    
    static int participants=70;     //éste es el número de participantes


    public static void main(String[] args) {//ésta es la parte principal del programa
        //el computador empieza a ejecutar el programa desde acá
        
        Random generator=new Random();//ésta me deja generar números aleatorios (un computador es incapaz de crear números verdaderamente aleatorios, pero éstos serán 'casi' aleatorios)
        
        int fails=0;    //cantidad de veces dónde ningunos dos cumpleaños eran iguales
        
        for(int k=0;k<5000;k++){     //la simulación estará ejectuada 'k' veces
        
            int[]people=new int[100000];    //100.000 cumpleaños están creados cada vez
        
            for(int i=0;i<100000;i++){  //genera los cumpleaños
                people[i]=generator.nextInt(365)+1;
            }
        
            int[]selected=new int[participants];
        
            for(int i=0;i<participants;i++){    //selecciona 'participants' participantes de todos los cumpleaños
                selected[i]=people[generator.nextInt(100000)];
            }
        
            boolean match=false;
        
            for(int i=0;i<(participants-1);i++){          //verifica si hay un cumpleaños compartido entre los seleccionados
                for(int j=i+1;j<participants;j++){
                    if(selected[i]==selected[j]){
                        match=true;
                        break;
                    }
                }
                if(match){
                    break;
                }
            }
        
            if(!match){     //sino, la cantidad de fracasos se aumenta por uno
                fails++;
            }
        }   //la simulación empieza de nuevo
        
        System.out.println("Cantidad de fracasos: "+fails);
        
    }
}
