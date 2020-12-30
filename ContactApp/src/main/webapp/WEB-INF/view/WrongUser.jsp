<script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js" ></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script >
	$(document).ready(function(){

	swal ( "Admin Authentication required!!!!" )
	setTimeout(function(){
            window.location.href = 'index.jsp';
         }, 3600);
});

</script>