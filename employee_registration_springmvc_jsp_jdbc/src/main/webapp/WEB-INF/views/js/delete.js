/**
 * 
 */
	$(document).ready(function () {

    var deleteLink = $("a:contains('Delete')");
 
    $(deleteLink).click(function(event) {
 
        $.ajax({
            url: $(event.target).attr("href"),
            type: "DELETE",
 
              beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
              },
 
            success: function(employee) {
                var respContent = "";
                var rowToDelete = $(event.target).closest("tr");
 
                rowToDelete.remove();
 
                respContent += "<span class='success'> Employee was deleted: [" ;
                respContent += employee.ID + " : ";
                respContent += employee.FirstName + " : " ;
                respContent += smartphone.LastName + "] </span>";
 
                $("#EmployeeFormResponses").html(respContent);  
                //setInterval('location.reload()', 7000);        
              },
      
        });
 
        event.preventDefault();
    });
 });
 