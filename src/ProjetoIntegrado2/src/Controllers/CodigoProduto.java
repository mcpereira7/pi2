/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Telas.CadastroProduto;
import Model.Produto;
import java.util.Set;

/**
 *
 * @author Red
 */
public class CodigoProduto {

    public static int CodigoFornecedor(Produto p) {
        int abc = 0;
        String cba = p.getFornecedor();

        switch (cba.charAt(0)) {
            case 'A':
                abc = 1;
                break;
            case 'B':
                abc = 2;
                break;
            case 'C':
                abc = 3;
                break;
            case 'D':
                abc = 4;
                break;
            case 'E':
                abc = 5;
                break;
            case 'F':
                abc = 6;
                break;
            case 'G':
                abc = 7;
                break;
            case 'H':
                abc = 8;
                break;
            case 'I':
                abc = 9;
                break;
            case 'J':
                abc = 10;
                break;
            case 'K':
                abc = 11;
                break;
            case 'L':
                abc = 12;
                break;
            case 'M':
                abc = 13;
                break;
            case 'N':
                abc = 14;
                break;
            case 'O':
                abc = 15;
                break;
            case 'P':
                abc = 16;
                break;
            case 'Q':
                abc = 17;
                break;
            case 'R':
                abc = 18;
                break;
            case 'S':
                abc = 19;
                break;
            case 'T':
                abc = 20;
                break;
            case 'U':
                abc = 21;
                break;
            case 'V':
                abc = 22;
                break;
            case 'W':
                abc = 23;
                break;
            case 'X':
                abc = 24;
                break;
            case 'Y':
                abc = 25;
                break;
            case 'Z':
                abc = 26;
                break;
            default:
                abc = 546;
                break;
        }

        return abc;
    }

    public static int CodigoTipo(Produto p) {
        int abc = 0;
        String tipo = p.getTipo();

        switch (tipo) {
            case "Jogos":
                abc = 1100;
                break;
            case "Periféricos":
                abc = 1200;
                break;
            case "Itens Diversos":
                abc = 1300;
                break;
            default:
                abc = 1404;
                break;
        }

        return abc;
    }

    public static int CodigoPlataforma(Produto p) {
        int abc = 0;

        String tipo = p.getPlataforma();

        switch (tipo) {
            case "Nintendo Switch":
                abc = 01;
                break;
            case "PC":
                abc = 2;
                break;
            case "Playstation 3":
                abc = 3;
                break;
            case "Playstation 4":
                abc = 4;
                break;
            case "Xbox 360":
                abc = 5;
                break;
            case "Xbox One":
                abc = 6;
                break;
            case "Wii":
                abc = 7;
                break;
            case "Wii U":
                abc = 8;
                break;
            default:
                abc = 14;
                break;
        }
        return abc;
    }

    public static int CodigoProduto(Produto p) {
        StringBuilder codigo = new StringBuilder();
        int c = 0;

        codigo.append(p.getDataCadastro());
        codigo.append(p.getNome().length());
        codigo.append(CodigoFornecedor(p));
        codigo.append(CodigoTipo(p));
        codigo.append(CodigoPlataforma(p));

        c = Integer.parseInt(codigo.toString());

        return c;
    }
}
