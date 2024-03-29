(function ()
{

    self.addEventListener('install', event =>{
        console.log('service worker is installing');

        event.waitUntil(
            caches
            .open('PWD_app')
            .then(cache => 
                caches.addAll([
                    '/git'
                ])
                )
        )
        self.skipWaiting();
    })

    self.addEventListener('activate',event=>{
        event.waitUntil(caches.delete('PWD_app'));
        console.log('service worker is activating'); 
    })

    self.addEventListener('fetch', event=>{
        console.log('fetching', event.request.url);
        event.respondWith(
            
            caches.match(event.request).then(async (response)=> 
            {
                if(response){
                    return response
                }
                 
            let data = fetch(event.request);
            let data_clone = (await data).clone();
            event.waitUntil(caches.open('PWD_app').then(cache => cache.put(event.request,data_clone)));
            return data

            })
        )
    })
}
)