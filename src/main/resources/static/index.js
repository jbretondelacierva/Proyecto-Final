
let getUsuario = async () => {

    let request0 = await fetch("/api/v1/login");
        if (request0.status == 200) {
            const data0 = await request0.text();
            console.log("usuario: "+ data0);
            var nombre = document.getElementById("nombre");
            nombre.innerHTML = data0;
        }
    
    }