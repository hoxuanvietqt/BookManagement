$(document).ready(function () {
    var search = {}
    search["bookTitle"] = "";
    search["pageNumber"] = 1;
    ajaxGetBooks(search);

	$('#search').click(function() {
	    search["bookTitle"] = $("#search-data").val();
	    search["pageNumber"] = 1;
	    ajaxGetBooks(search);
	});
});

function ajaxGetBooks(search) {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/api/book/search",
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
        	var html = "";
            $.each( data.content, function( key, val ) {
            	html += "<tr>"
                html +='<td><a href="/bookDetail?bookId=' + val.bookId + '">' + val.title + '</a></td>';
            	html +="<td>" + val.author + "</td>";
            	html += '<td><a href="/updateBook?bookId=' + val.bookId + '">Edit </a>';
               	html += '<a href="/deleteBook?bookId='+ val.bookId +'"> Delete</a></td>';
            	html += "</tr>"
             });
            
            $('#bookContent').html(html);
            
            var pagingButton = '<button >Total Pages: ' + data.totalPages + '</button>';
            pagingButton += '<button class="paging-button"  data-page="1">First</button>';
            if (data.first) {
            	pagingButton += '<button class="paging-button" disabled data-page="' + (data.number) + '">Previous</button>';
            } else {
            	pagingButton += '<button class="paging-button" data-page="' + (data.number) + '">Previous</button>';
            }
            pagingButton += '<button class="paging-button" data-page="' + (data.number + 1) + '">Current page ' + (data.number + 1) + '</button>';
            if (data.last) {
            	pagingButton += '<button  class="paging-button" disabled  data-page="' + (data.number + 2) + '">next</button>';
            } else {
            	pagingButton += '<button  class="paging-button"  data-page="' + (data.number + 2) + '">Next</button>';
            }
            
            if (data.totalPages == 0) {
            	pagingButton += '<button  class="paging-button"  data-page="1">Last</button>';
            } else {
            	pagingButton += '<button  class="paging-button"  data-page="' + (data.totalPages) + '">Last</button>';
            }
            
            $("#pagingButton").html(pagingButton);

        	$('.paging-button').click(function() {
        	    search["bookTitle"] = $("#search-data").val();
        	    search["pageNumber"] = $(this).attr("data-page");
        	    ajaxGetBooks(search);
        	});
        	
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });
}