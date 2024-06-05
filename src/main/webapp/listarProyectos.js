document.addEventListener('DOMContentLoaded', function() {
    fetch('listarProyectos')
        .then(response => response.json())
        .then(data => pintarTabla(data))
        .catch(error => console.error('Error fetching data:', error));
});

function pintarTabla(datos) {
    let html = "<table>";
    html += "<tr><th>NOMBRE</th><th>PROPIETARIO</th></tr>";

    datos.forEach(proyecto => {
        html += "<tr>";
        html += `<td>${proyecto.nombreProyecto}</td>`;
        html += `<td>${proyecto.usuarioAdministrador}</td>`;
        html += "</tr>";
    });

    html += "</table>";

    document.getElementById("listado").innerHTML = html;

    console.log(datos); // para comprobar
}
