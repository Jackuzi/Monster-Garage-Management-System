//passing id for edit modal dialog
function viewCarsModal(id) {
    console.log(id);
    $.ajax({
        url: "/carsAndCustomers/cars/edit/" + id,
        success: function (data) {
            //alert('success');
            console.log(data);
            $('#viewCarHolder').html(data);
            $('#modal-default').modal('show');
        }
    });
}

//alert notification auto-close
window.setTimeout(function () {
    $(".alert").fadeTo(500, 0).slideUp(500, function () {
        $(this).remove();
    });
}, 5000);

//search car table
$(document).ready(function () {
    console.log("document loaded");
    $("#inputFilter").on("keyup", function () {
        var inputValue = $(this).val().toLowerCase();
        $("#carsTable tr").filter(function () {
            $(this).toggle($(this).text().toLowerCase().indexOf(inputValue) > -1)
        });
    });
});

