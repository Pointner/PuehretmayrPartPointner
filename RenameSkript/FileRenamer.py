import os
import pathlib

folder = 'C:/Schule/Github/Teachable-Machine/Scaler/Teachablemachinescaler/pictures/Orang-Utan Affe/'
count = 1
# count increase by 1 in each iteration
# iterate all files from a directory
for file_name in os.listdir(folder):
    # Construct old file name
    source = folder + file_name

    # Adding the count to the new file name and extension
    destination = folder + "OrangUtan_" +str(count) + pathlib.Path(file_name).suffix

    # Renaming the file
    os.rename(source, destination)
    #print(destination)
    count += 1

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
