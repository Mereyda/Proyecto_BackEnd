window.addEventListener('load', function () {

    const formulario = document.querySelector('#form_paciente');
    formulario.addEventListener('submit', function (event) {

        let paciente_id = document.querySelector('#paciente_id').value;

        const formData = {
            id: document.querySelector('#paciente_id').value,
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            dni: document.querySelector('#dni').value,
            dni: document.querySelector('#email').value,
            fechaIngreso: document.querySelector('#fechaIngreso').value,
        };

        const url = '/pacientes';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
        fetch(url, settings)
            .then(response => response.json())

    })
})

function findBy(id) {
    const url = '/pacientes/' + id;
    const settings = {
        method: 'GET'
    }
    fetch(url, settings)

        .then(response => response.json())

        .then(data => {
            let paciente = data;
            document.querySelector('#paciente_id').value = paciente.id;
            document.querySelector('#nombre').value = paciente.nombre;
            document.querySelector('#apellido').value = paciente.apellido;
            document.querySelector('#dni').value = paciente.dni;
            document.querySelector('#email').value = paciente.email;
            document.querySelector('#fechaIngreso').value = paciente.fechaIngreso;
            document.querySelector('#div_paciente_put').style.display = "block";
        })

        .catch(error => {
            alert("Error: " + error);
        })
}