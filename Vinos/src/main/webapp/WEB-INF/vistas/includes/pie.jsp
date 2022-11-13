<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <script>
$(function () {
    $('table').DataTable({
        language: {
            url: 'json/es-ES.json'
        }
    });
} );
</script>  
 
 <script>

(function () {
  'use strict'

  // Fetch all the forms we want to apply custom Bootstrap validation styles to
  var forms = document.querySelectorAll('.needs-validation')

  // Loop over them and prevent submission
  Array.prototype.slice.call(forms)
    .forEach(function (form) {
      form.addEventListener('submit', function (event) {
        if (!form.checkValidity()) {
          event.preventDefault()
          event.stopPropagation()
        }

        form.classList.add('was-validated')
      }, false)
    })
})()
</script>
    
</main>
<footer class="mt-auto bg-primary text-white border border-5 border-secondary pt-3 mx-2">
	<p class="text-center">&copy; 2022 Manuel</p>
</footer>
</body>
</html>