//cogerDatos();

let getUsuario = async () => {

let request0 = await fetch("/api/v1/login");
    if (request0.status == 200) {
        const data0 = await request0.text();
        console.log("usuario: "+ data0);
        var nombre = document.getElementById("nombre");
        nombre.innerHTML = data0;
        return data0;
    }

}

let cogerDatos = async () => {
    
    let nombre= await getUsuario();
    console.log("funcionara??"+nombre);
    let request = await fetch("/api/v1/contactos/"+nombre);
    if (request.status == 200) {
        const data = await request.json();
        var table = document.getElementById("table");
        var i;
        for (i = 0; i < data.length; i++) {
            var row = table.insertRow();
            for (var clave in data[i]){
                var cell = row.insertCell();
                //if(clave=data[i].length){
                //    cell = row.insertCell();
                 //   cell.innerHTML = '<button>Ver gastos</button>';
                //    console.log("joder");
                //}else{
                cell.innerHTML= data[i][clave];
                //    console.log(data[i].length);
                //}
                console.log(i+clave);
                //cell.innerHTML = '<button>Ver gastos</button>';

                
            }
            //cell = row.insertCell();
            //cell.innerHTML = '<button'+' href="/gastos.html">Ver gastos de '+data[0]["username"]+'</button>';

    }   
}

};



const postContactos = async () => {
    let user_name= await getUsuario();

    try {
        let inputPeriodo = document.getElementById("Nombre").value;
        console.log(inputPeriodo);
        let inputConcepto = document.getElementById("Apellido").value;
        console.log(inputConcepto);
        let inputImporte = document.getElementById("Email").value;
        console.log(inputImporte);
        let inputFecha = document.getElementById("Direccion").value;
        console.log(inputFecha);
        var data = {
            "id_contacto": null,
            "username":user_name,
            "nombre":inputPeriodo,
            "apellido":inputConcepto,
            "mail":inputImporte,
            "direccion":inputFecha
            };

            const address = 'api/v1/contactos';
            let request = fetch(address, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body:JSON.stringify(data)
                })
                .then(response => response.json())
                .then(data => {
                    console.log(data);
                    console.log("data status: "+data.status);
                    if(data.status >= 300) {
                        alert("Error.");
                    } else {
                        alert("Contacto Creado");
                        document.location.href="/contactos.html";
                    }

                });
            
    } catch (err) {
        console.error(err.message);
    }
    return false;
};

