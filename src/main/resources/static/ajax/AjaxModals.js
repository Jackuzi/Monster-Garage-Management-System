//passing id for edit modal dialog

//editing car
function viewCarsModal(id, choice) {
    console.log(id);
    var url = "";
    var object = '';
    var modalid = '';

    switch (choice) {
        case "customer":
            url = "/carsAndCustomers/cars/edit/customer/" + id;
            object = '#viewCustomerHolder';
            modalid = '#modal-customerEdit';
            break;
        case "car":
            url = "/carsAndCustomers/cars/edit/" + id;
            object = '#viewCarHolder';
            modalid = '#modal-editCar';
            break;
    }
    $.ajax({
        url: url,
        success: function (data) {
            //alert('success');
            console.log(data);
            $(object).html(data);
            $(modalid).modal('show');
        }
    });
}

//new car adding
function viewCarsModalAdd() {
    $.ajax({
        url: "/carsAndCustomers/cars/new",
        success: function (data) {
            //alert('success');
            console.log(data);
            $('#viewCarHolder').html(data);
            $('#modal-default').modal('show');
        }
    });
}

//deleting car
function deleteCarConfirmation(id) {
    console.log(id);
    $.ajax({
        url: "/carsAndCustomers/cars/delete/" + id,
        success: function (data) {
            //alert('success');
            console.log(data);
            $('#deleteHolder').html(data);
            $('#modal-delete').modal('show');
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

//creating parts list
var index = 1;

function addToPartsList() {
    var name = $("#partName").val();
    var quantity = $("#quantity").val();
    var invoice = $("#invoiceNumber").val();
    var price = $("#price").val();
    var supplier = $("#supplier").val();
    var brand = $("#brand").val();

    $(
        '<div class="col-10" >' +
        ' <input class="form-control" id="parts' + index + '.name" name="parts[' + index + '].name" type="text" value="' + name + '"> ' +
        '<input class="form-control" id="parts' + index + '.quantity" name="parts[' + index + '].quantity" type="text" value="' + quantity + '"> ' +
        '<input class="form-control" id="parts' + index + '.invoiceNumber" name="parts[' + index + '].invoiceNumber" type="text" value="' + invoice + '"> ' +
        '<input class="form-control" id="parts' + index + '.price" name="parts[' + index + '].price" type="text" value="' + price + '"> ' +
        '<input class="form-control" id="parts' + index + '.supplier" name="parts[' + index + '].supplier" type="text" value="' + supplier + '"> ' +
        '<input class="form-control" id="parts' + index + '.brand" name="parts[' + index + '].brand" type="text"' +
        ' value="' + brand + '"> ' +
        '</div>'
    ).appendTo('#collapse1');
    index++;
}