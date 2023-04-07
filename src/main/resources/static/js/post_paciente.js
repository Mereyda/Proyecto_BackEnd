window.addEventListener('load', function () {

    const formulario = document.querySelector('#nuevo_paciente');

    formulario.addEventListener('submit', function (event) {

        const formData = {
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            dni: document.querySelector('#dni').value,
            email: document.querySelector('#email').value,
            fechaIngreso: document.querySelector('#fechaIngreso').value,
        };

        const url = '/pacientes';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }




     fetch(url, settings)
                .then(response => response.json())
                .then(data => {
                   //Si no hay ningun error se muestra un mensaje diciendo que el paciente
                   //se agrego bien
                     let successAlert = '<div class="alert alert-success alert-dismissible">' +
                         '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                         '<strong></strong> Paciente agregado </div>'

                     document.querySelector('#response').innerHTML = successAlert;
                     document.querySelector('#response').style.display = "block";
                     //se dejan todos los campos vacíos por si se quiere ingresar otro paciente
                     resetUploadForm();

                })
                .catch(error => {
                     //Si hay algun error se muestra un mensaje diciendo que el paciente
                     //no se pudo guardar y se intente nuevamente
                      let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                         '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                         '<strong> Error!! intente nuevamente</strong> </div>'

                       document.querySelector('#response').innerHTML = errorAlert;
                       document.querySelector('#response').style.display = "block";
                       //se dejan todos los campos vacíos por si se quiere ingresar otro paciente
                       resetUploadForm();})
        });

    function resetUploadForm() {
        document.querySelector('#nombre').value = "";
        document.querySelector('#apellido').value = "";
        document.querySelector('#dni').value = "";
        document.querySelector('#email').value = "";
        document.querySelector('#fechaIngreso').value = "";
    }

    (function () {
        let pathname = window.location.pathname;
       if (pathname === "/") {
            document.querySelector(".nav .nav-item a:first").addClass("active");
       } else if (pathname == "/listaPaciente.html") {
         document.querySelector(".nav .nav-item a:last").addClass("active");
       }
    })();
});