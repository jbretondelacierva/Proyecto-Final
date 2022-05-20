let API_KEY="7f1ac9e2a6deeea5fbf2dbb18d570a7e"; //47b73294df5f543b8ab9365cc2e18fe7
var elementos = document.getElementById("name");

let Ciudad = "A Coruña";
let url = "http://api.openweathermap.org/data/2.5/weather?q="+Ciudad+"&APPID="+API_KEY+"&units=metric";
let coord = {lat:-34.5956145 ,lon: -58.4431949};
async function getApi(){
    let Ciudad = elementos.value;
    let url = "https://api.openweathermap.org/data/2.5/weather?q="+Ciudad+"&APPID="+API_KEY+"&units=metric";
    let respuesta = await fetch(url);
    if(respuesta.ok){
        console.log(respuesta);
        let datos = await respuesta.json();
        console.log(datos);
        let informacion = "Temperaturas: " + datos.main.temp + "ºC<br/> Descripcion: "+ datos.weather[0].main + ", " + datos.weather[0].description;
        document.getElementById("hola").innerHTML = informacion;
        let coord = datos.coord;
        coord1 =[coord.lat,coord.lon];
        map.flyTo(coord,9);

        console.log(coord1);
    }
}

function myFunction() {
    event.preventDefault();
    getApi();
    console.log(elementos.value);
    elementos = document.getElementById("name");

}

let map = L.map('map').setView([43.37,-8.39],5)

//Agregar tilelAyer mapa base desde openstreetmap
L.tileLayer('https://{s}.basemaps.cartocdn.com/light_all/{z}/{x}/{y}.png',{
    attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
}).addTo(map);

async function inicio(){
    let Ciudad = "A coruña";
    let url = "https://api.openweathermap.org/data/2.5/weather?q="+Ciudad+"&APPID="+API_KEY+"&units=metric";
    let respuesta = await fetch(url);
    if(respuesta.ok){
        console.log(respuesta);
        let datos = await respuesta.json();
        console.log(datos);
        let informacion = "Temperaturas: " + datos.main.temp + "ºC<br/> Descripcion: "+ datos.weather[0].main + ", " + datos.weather[0].description;
        document.getElementById("hola").innerHTML = informacion;
        let coord = datos.coord;
        coord1 =[coord.lat,coord.lon];
        map.flyTo(coord,9);

        console.log(coord1);
    }
}

inicio();




