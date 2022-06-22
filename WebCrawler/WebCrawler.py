from google_images_search import GoogleImagesSearch
import threading, os



def search(query):
    print(f'Searching for {query_str}')
    try: 
        os.mkdir('path/'+query)
    except: 
        pass

    _search_params = {
        'q': query,
        'num': 250
    }

   
    gis = GoogleImagesSearch('AIzaSyB2wwkOu9uczr6l1Xx_9TbsH1AAiyVfjdw', 'b4b1b01e9779743b6')
    gis.search(search_params=_search_params, path_to_dir='path/'+query+'/')
    i = 1
    for path in pathlib.Path("Change des zu dem Pfad wo des bei dir liegt + query").iterdir():
        old_extension = path.suffix
        directory = path.parent
        new_name = query + "_" + i + old_extension
        path.rename(pathlib.Path(directory, new_name))
        i += 1
 

if __name__ == '__main__':
    try: 
        os.mkdir('path')
    except: 
        pass
    for i in range(1, 5):
        query_str = input(f'Enter query [{i}]: ')
        try:
            thread = threading.Thread(target=search, args=(query_str,))
            thread.start()
        except KeyboardInterrupt:
            thread.__stop()
            break
        print('\n'+'-'*50)
        print()