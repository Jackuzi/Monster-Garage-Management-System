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

