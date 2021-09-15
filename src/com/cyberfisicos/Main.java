package com.cyberfisicos;
import com.cyberfisicos.vounneumann.*;
//Douglas Miranda
//Julio Krause
//Lucas Silva
//Matheus Bastos
//Renan Maciel


// A capacidade da cache deverá ser de 8192 palavras com cada cache line armazenando 64 palavras (i.e., K=64).

public class Main {


    public static void main(String[] args) {
        IO io  = new IO(System.out);
        RAM ram = new RAM(24); // tamanho da memória principal é de 16M, a CPU gerará endereços de 24 bits
        Cache cache = new Cache(2, ram);

        CacheL1 cacheL1 = new CacheL1(7,6, ram); // Primeiro atributo representa 7 o tamanho do numero de bits sendo
                                                 // 8192 / 64 = 128 cache lines =  7 bits e o segundo o tamanho de K
                                                 // K = 64 =  6 bits
        CPU cpu = new CPU(cacheL1, io);

        try {
            final int start = 10;

            ram.write(start, 118);      // valor de inicio do execução
            ram.write(start + 1, 200);  // valor final e fim da execução, esse valor devere ser aumentado caso o valor de K
                                        // seja alterado para poder visualizar as mudanças no HIT e MISS ( EX 6 bits = 64 - 128 - 192
                                        // EX 7 bits = 128 - 256 - 384 )

            cpu.run(start);
        } catch (EnderecoInvalido ei) {
            System.err.println(ei.toString());
        }
    }
}
