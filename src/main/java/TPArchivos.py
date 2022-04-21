import os
import random
import struct

def aeropuerto(nombreArchivo, n, formato):

    if os.path.exists(nombreArchivo):
            os.remove(nombreArchivo)
            fp = open (nombreArchivo, "w+b")
    else:
        fp = open (nombreArchivo, "w+b")

    for i in range(n):
        numeroDeDestino = random.randint(1, 16)
        capacidadDelAvion = random.randint(110, 225)
        cantidadDePasajeros = random.randint(0, capacidadDelAvion)
        contenido = struct.pack(formato, numeroDeDestino, capacidadDelAvion, cantidadDePasajeros)
        fp.write(contenido)

    fp.close()


def promedio(nombreArchivo, formato, destinos):

    datos = []
    
    for i in range(destinos):
        datos.append([0,0])

    fp = open (nombreArchivo, "rb")
    qty_reg =  int (os.path.getsize(nombreArchivo)//struct.calcsize(formato))
    for i in range(qty_reg):
        resultado = fp.read(struct.calcsize(formato))
        resultadoF = struct.unpack(formato, resultado)
        
        datos[resultadoF[0] - 1] [0] += 1
        datos[resultadoF[0] - 1] [1] += resultadoF[1] - resultadoF[2]
    
    listaProm = []

    x = 0 
    for i in range(destinos):
        if datos[x][0] == 0:
            listaProm.append(0)
        else:
            listaProm.append( int(datos[x][1] / datos[x][0]) )
        x += 1

    return listaProm

def listaPromPrinter(lista):
    x = 1
    
    for i in lista:
        print(f"destino {x}: {i}")
        x+=1

def vuelosRealizados(nombreArchivo, formato, destinos, archivoNuevo):

    datos = []
    
    for i in range(destinos):
        datos.append(0)

    fp = open (nombreArchivo, "rb")
    qty_reg =  int (os.path.getsize(nombreArchivo)//struct.calcsize(formato))
    for i in range(qty_reg):
        resultado = fp.read(struct.calcsize(formato))
        resultadoF = struct.unpack(formato, resultado)
        
        datos[resultadoF[0] - 1] += 1

    if os.path.exists(archivoNuevo):
            os.remove(archivoNuevo)
            fp = open (archivoNuevo, "w+b")
    else:
        fp = open (archivoNuevo, "w+b")

    for i in range(destinos):
        contenido = struct.pack("ll", (i+1), datos[i])
        fp.write(contenido)
    
    fp.close()

aeropuerto('info', 25, 'lll')

listaPromPrinter(promedio('info', 'lll', 16))

vuelosRealizados('info', 'lll', 16, 'vuelos')

