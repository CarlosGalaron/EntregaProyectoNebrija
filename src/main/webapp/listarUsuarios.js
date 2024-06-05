document.addEventListener('DOMContentLoaded', function() {
    fetch('listarUsuarios')
        .then(response => response.json())
        .then(data => pintarTabla(data))
        .catch(error => console.error('Error fetching data:', error));
});

function pintarTabla(datos) {
    let html = "<table>";
    html += "<tr><th>NOMBRE</th><th>EMAIL</th></tr>";

    datos.forEach(usuario => {
        html += "<tr>";
        html += `<td>${usuario.nombreUsuario}</td>`;
        html += `<td>${usuario.correoUsuario}</td>`;
        html += "</tr>";
    });

    html += "</table>";

    document.getElementById("listado").innerHTML = html;

    console.log(datos); // para comprobar
}
