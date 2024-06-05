document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const formData = new FormData(this);
    fetch('SvGestionUsuario?action=login', {
        method: 'POST',
        body: formData
    })
    .then(response => response.json())
    .then(data => {
        if (data.success) {
            alert('Bienvenido a ArqueoTech Solutions');
            window.location.href = 'Index.html';
        } else {
            alert('Error en el login: ' + data.error);
        }
    })
    .catch(error => console.error('Error:', error));
});