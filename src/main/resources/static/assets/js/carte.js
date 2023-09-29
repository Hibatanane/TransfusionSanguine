var mymap = L.map('mapid').setView([51.505, -0.09], 13);

L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors',
    maxZoom: 18,
}).addTo(mymap);

if ("geolocation" in navigator) {
    navigator.geolocation.getCurrentPosition(function(position) {
        var lat = position.coords.latitude;
        var lng = position.coords.longitude;

        L.marker([lat, lng]).addTo(mymap);
    });
}

if ("geolocation" in navigator) {
    navigator.geolocation.getCurrentPosition(function(position) {
        var lat = position.coords.latitude;
        var lng = position.coords.longitude;

        L.marker([lat, lng]).addTo(mymap);

        // Enregistrer les coordonnées dans des champs de formulaire cachés
        var latInput = document.getElementById("lat");
        var lngInput = document.getElementById("lng");
        latInput.value = lat;
        lngInput.value = lng;
    });
}