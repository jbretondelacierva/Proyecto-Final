//cogerDatos();
var user_name;
let getUsuario = async () => {

let request0 = await fetch("/api/v1/login");
    if (request0.status == 200) {
        const data0 = await request0.text();
        console.log("usuario: "+ data0);
        var nombre = document.getElementById("nombre");
        nombre.innerHTML = data0;
        user_name = data0;
    }

}

let cogerDatos = async () => {
    

    let request = await fetch("/api/v1/users/periodos");
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
            cell = row.insertCell();
            const a = document.createElement("button");
            a.textContent ="Ver gastos de " +  data[i]["nombre_periodo"];
            //texto = new String('<button onclick="verGastos("Verano");">Ver gastos de '+periodo+'</button>');
            a.setAttribute("onclick", 'verGastos("'+ data[i]["nombre_periodo"]+'")')
            cell.appendChild(a);
            //cell.innerHTML = texto;
            //console.log(texto);
        }   
    }
};

let verGastos = async (periodo) => {
    console.log("funciona el boton: "+periodo);

    let request = await fetch("/api/v1/gastos/periodo/"+periodo+"/"+user_name);
    if (request.status == 200) {
        const data = await request.json();
        var table = document.getElementById("tablegastos");
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
            

        }   
    }
}


const postGastos = async () => {
    try {
        let inputPeriodo = document.getElementById("Periodo").value;
        console.log(inputPeriodo);
        let inputConcepto = document.getElementById("Concepto").value;
        console.log(inputConcepto);
        let inputImporte = document.getElementById("Importe").value;
        console.log(inputImporte);
        let inputFecha = document.getElementById("Date").value;
        console.log(inputFecha);
        var data = {
            "id_gasto": null,
            "username":user_name,
            "nombre_periodo":inputPeriodo,
            "concepto":inputConcepto,
            "importe":inputImporte,
            "fecha":inputFecha
            };

            const address = 'api/v1/gastos';
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
                        alert("Gasto Creado");
                        document.location.href="/periodos.html";
                    }

                });
            
    } catch (err) {
        console.error(err.message);
    }
    return false;
};
