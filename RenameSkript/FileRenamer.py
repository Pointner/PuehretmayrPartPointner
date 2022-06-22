import os
import pathlib

folder = 'Hier Folder Path der zu ändernden Files eingeben'
count = 1

for file_name in os.listdir(folder):

    source = folder + file_name


    destination = folder + "OrangUtan_" +str(count) + pathlib.Path(file_name).suffix


    os.rename(source, destination)
    #print(destination)
    count += 1

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
