import java.util.Scanner;


public class ClaseTelevision{
    int channel;
    int volumeLevel;
    boolean power;

    public ClaseTelevision(){
        this.channel = 1;
        this.volumeLevel = 1;
        this.power = false;
    }

    public void turnOn(){
        if(this.power != true){
            this.power = true;
        }else{
            System.err.println("La television ya esta prendida");
        }
    }

    public void turnOff(){
        if(power != false){
            this.power = false;
        }else{
            System.err.println("La television ya esta apagada");
        }
    }

    public void setChannel (int channel){
        if(power == true){
            if(channel < 120 && channel > 1){
                this.channel = channel;
                System.out.println("El canal seleccionado es:" + channel);
            }else{
                System.err.println("Error, el canal no existe, elija un canal dentro del 1 y el 120");
            }
        }else{
            System.err.println("La television esta apagada");
        }
    }

    public void setVolume(int volumeLevel){
        if(power == true){
            if(volumeLevel < 7 && volumeLevel >1){
                this.volumeLevel = volumeLevel;
                System.out.println("El volumen seleccionado es: "+ volumeLevel);
            }else{
                System.err.println("El volumen seleccionado esta fuera de los parametros");
            }
        }else{
            System.err.println("La television esta apagada");
        }
    }

    public void channelUp(){
        if(power == true){
            if(channel == 120){
                System.out.println("Es el ultimo canal , no se puede subir mas");
            }else{
                channel++;
                System.out.println("Ahora estas en el canal " + channel );
            }
        }else{
            System.out.println("La tele esta apagada");
        }
    }

    public void channelDown(){
        if(power == true){
            if(channel == 1){
                System.out.println("Canal minimo, no se puede bajar mas");
            }else{
                channel--;
                System.err.println("Ahora estas en el canal "+ channel);
            }
        }else{
            System.err.println("La tele esta apagada");
        }
    }

    public void volumeUp(){
        if(power == true){
            if(volumeLevel == 7){
                System.out.println("Volumen maximo , no se puede subir mas");
            }else{
                volumeLevel++;
                System.err.println("El volumen ahora esta en "+ volumeLevel);
            }
        }else{
            System.err.println("La tele esta apagada");
        }
    }

    public void volumeDown(){
        if(power == true){
            if(volumeLevel == 1){
                System.out.println("Volumen minimo, no se puede bajar mas");
            }else{
                volumeLevel--;
                System.out.println("El volumen ahora esta en "+ volumeLevel);
            }
        }else{
            System.err.println("La tele esta apagada");
        }
    }

    public static void main(String [] args){
        int channel = 0;
        int volume = 0;
        int i = 0;
        String terminador = null;
        Scanner input = new Scanner(System.in);

        ClaseTelevision Tv1 = new ClaseTelevision();

        while(!"x".equals(terminador)){
            System.out.println("Bienvenido al entorno de television");
            System.out.print("Para encender la tele, Presiona 'i'.\nPara apagar la tele presiona 'o' \nPara elegir el canal presiona 'c'. \nPara elegir el volumen presiona 'v'. \nPara subir el canal presione 'a' \nPara bajar el canal presione 'd'\nPara subir el volumen presione 'w'\nPara bajar el volumen presione 's'\n");
            terminador = input.next();

            switch (terminador) {
                case "i":
                    Tv1.turnOn();
                    break;
                case "o":
                    Tv1.turnOff();
                    break;
                case "c":
                    do{
                        System.out.println("Seleccione el valor del canal: ");
                        channel = input.nextInt();
                        if(channel > 120 && channel < 1){
                            System.err.println("El numero que escribiste no coincide con la lista de canales, intentelo de nuevo");
                            i++;
                        }
                    }while (channel > 120 && channel <1 || i == 3); 
                    Tv1.setChannel(channel);
                    break;
                case "v":
                    do{
                        System.out.println("Seleccione el valor del canal: ");
                        volume = input.nextInt();
                        if(volume > 7 && volume < 1){
                            System.err.println("El numero que escribiste no coincide con la lista de canales, intentelo de nuevo");
                            i++;
                        }
                    }while (volume > 7 && volume <1 || i != 3); 
                    Tv1.setVolume(volume);
                    break;
                case "a":
                    Tv1.volumeDown();
                    break;
                case "d":
                    Tv1.volumeUp();
                    break;
                case "w":
                    Tv1.channelUp();
                    break;
                case "s":
                    Tv1.channelDown();
                    break;
            
                default:
                    if("x".equals(terminador)){
                        System.out.println("Saliendo del control");
                    }else{
                        System.err.println("Error, selecciona una letra correcta");
                    }
                    break;
            }
           
        }

        
    }
}