//passing id for edit modal dialog

//editing car
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
var index = 0;

function addToPartsList() {
    var name = $("#partName").val();
    var quantity = $("#quantity").val();
    var invoice = $("#invoiceNumber").val();
    var price = $("#price").val();
    var supplier = $("#supplier").val();
    var brand = $("#brand").val();


    $(
        '<div class="col-10" > <input class="form-control" field="parts[' + index + '].name"' +
        ' type="text" value="' + name + '"> <input class="form-control" field="parts[' + index + '].quantity"' +
        ' type="text" value="' + quantity + '"> <input class="form-control" field="parts[' + index + '].invoiceNumber"' +
        ' type="text" value="' + invoice + '"> <input class="form-control" field="parts[' + index + '].price"' +
        ' type="text" value="' + price + '"> <input class="form-control" field="parts[' + index + '].supplier"' +
        ' type="text" value="' + supplier + '"> <input class="form-control" field="parts[' + index + '].brand"' +
        ' type="text" value="' + brand + '"> </div>'
    ).appendTo('#collapse1');
    index++;
}