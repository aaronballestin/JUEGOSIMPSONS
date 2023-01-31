import java.util.*;

public class App {

    public static void moverBart(int posicionX, int posicionY, char[][] tablero) {
        tablero[posicionX][posicionY] = 'B';

    }

    public static void setHomer(int posicionX, int posicionY, char[][] tablero) {
        tablero[posicionX][posicionY] = 'H';
    }

    public static void rellenarTableroKrusty(char[][] tablero) {
        int contador = 0;

        while (contador <= 10) {
            int posicionx = (int) (Math.random() * 5);
            int posiciony = (int) (Math.random() * 5);

            if (tablero[posicionx][posiciony] != 'B' && tablero[posicionx][posiciony] != 'C' && tablero[posicionx][posiciony] != 'K') {
                tablero[posicionx][posiciony] = 'K';
                contador++;
            }

        }
    }

    public static void rellenarTableroFlanders(char[][] tablero) {
        int contador = 0;

        while (contador <= 10) {
            int posicionx = (int) (Math.random() * 5);
            int posiciony = (int) (Math.random() * 5);

            if (tablero[posicionx][posiciony] != 'H') {
                tablero[posicionx][posiciony] = 'F';
                contador++;
            }

        }
    }

    public static int posicionAleatoria() {
        return (int) (Math.random() * 5);
    }

    public static void casillaFinal(char[][] tablero) {
        tablero[4][4] = 'C';
    }

    public static void rellenarTablero(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j] != 'H' && tablero[i][j] != 'B' && tablero[i][j] != 'F' && tablero[i][j] != 'K'
                        && tablero[i][j] != 'C') {
                    tablero[i][j] = 'L';
                }
            }
        }
    }

    public static void mostrarTablero(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static boolean ganar(char [][] tablero){
        return (tablero[4][4] == 'B') || (tablero[4][4] == 'H');
    }

    public static void movimiento(char letra, char[][] tablero ) {
        int X=0; int Y=0;
        char personaje='n';
        for(int i = 0; i<tablero.length;i++){
            for(int j= 0;j<tablero.length;j++){
                if(tablero[i][j] == 'B' || tablero[i][j] == 'H'){
                    X = i;
                    Y = j;
                    personaje = tablero[i][j];
                }
            }
        }
        switch (letra) {
            case 'D':
                if (Y == 4) {
                    System.out.println("No se puede mover");
                } else {
                    tablero[X][Y] = 'L';
                    tablero[X ][Y + 1] = personaje;
                }
                break;
            case 'A':
                if (Y == 0) {
                    System.out.println("No se puede mover");
                } else {
                    tablero[X][Y] = 'L';
                    tablero[X ][Y + 1] = personaje;
                }
                break;
            case 'W':
                if (X == 0) {
                    System.out.println("No se puede mover");
                } else {
                    tablero[X][Y] = 'L';
                    tablero[X - 1][Y ] = personaje;
                }
                break;
            case 'S':
                if (X == 4) {
                    System.out.println("No se puede mover");
                } else {
                    tablero[X][Y] = 'L';
                    tablero[X+ 1 ][Y ] = personaje;
                }
                break;
            case 'E':
                if (X == 4 || Y == 0) {
                    System.out.println("No se puede mover");
                } else {
                    tablero[X][Y] = 'L';
                    tablero[X + 1][Y - 1] = personaje;
                }
                break;
            case 'Q':
                if (X == 0 || Y == 0) {
                    System.out.println("No se puede mover");
                } else {
                    tablero[X][Y] = 'L';
                    tablero[X - 1][Y - 1] = personaje;
                }
                break;
            case 'X':
                if (Y == 4 || X == 4) {
                    System.out.println("No se puede mover");
                } else {
                    tablero[X][Y] = 'L';
                    tablero[X + 1][Y + 1] = personaje;
                }
                break;
            case 'Z':
                if (Y == 4 || X == 0) {
                    System.out.println("No se puede mover");
                } else {
                    tablero[X][Y] = 'L';
                    tablero[X - 1][Y + 1] = personaje;
                }
                break;
        }
    }

    public static void main(String[] args) throws Exception {
        boolean ganado = false;
        Scanner teclado = new Scanner(System.in);
        char[][] tablero1 = new char[5][5];
        char[][] tablero2 = new char[5][5];
        int posicionXBart = posicionAleatoria();
        int posicionYBart = posicionAleatoria();
        moverBart(posicionXBart, posicionYBart, tablero1);
        casillaFinal(tablero1);
        rellenarTableroKrusty(tablero1);
        rellenarTablero(tablero1);
        setHomer(posicionAleatoria(), posicionAleatoria(), tablero2);
        casillaFinal(tablero2);
        rellenarTableroFlanders(tablero2);
        rellenarTablero(tablero2);
        while (!ganado) {
            System.out.println("--Tablero1--");
            mostrarTablero(tablero1);
            System.out.println("Mueve");
            char movimiento = teclado.next().charAt(0);
            movimiento(movimiento, tablero1);
            ganado = ganar(tablero1);
        }
    }
}
