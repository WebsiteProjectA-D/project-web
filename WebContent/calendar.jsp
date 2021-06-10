<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container-fluid">
        <div class="row">
          
          <!-- /.col -->
          <div class="col-md-12">
            <div class="card card-primary">
              <div class="card-body p-0">
                <!-- THE CALENDAR -->
                <div id="calendar"></div>
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
          </div>
          <!-- /.col -->
        </div>
        <!-- /.row -->
      </div><!-- /.container-fluid -->
      
      <div class="modal fade" id="myModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Visite</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="row">
						<!-- /.card-header -->
						<!-- form start -->
						<form role="form">
						<input type="hidden" class="form-control" id="cinMed"/>
							<div class="card-body">
								 <dl>
					                  <dt>Date visite</dt>
					                  <dd id="dv"></dd>
					                  <dt>Heure visite</dt>
					                  <dd id="hv"></dd>
					                  <dt>Observation</dt>
					                  <dt>
					                  <div class="form-group">
                        				<textarea class="form-control" rows="4" placeholder="Observation ..." id="obs"></textarea>
                     				 </div>
                     				 </dt>
               					 </dl>
							</div>



						</form>
					</div>
				</div>

				<div class="modal-footer justify-content-between">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-warning" id="saveVst">créer une visite</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
    <script id="jsbin-javascript">
    
$(function() { // document ready
	const formatYmd = date => date.toISOString().slice(0, 10);
  $('#calendar').fullCalendar({
			header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month,basicWeek,basicDay'
			},
			'themeSystem': 'bootstrap',
			defaultDate: formatYmd(new Date()),
			navLinks: true, // can click day/week names to navigate views
			editable: false,
			eventLimit: true, // allow "more" link when too many events
			events: "/projet_web/CalendarJsonServlet",
			eventRender: function (event, element, view) {
			    element.find('.fc-content').attr("id", "event-" + event.id);
			},
			eventClick: function (event, jsEvent, view) {
				$("#dv").html(formatYmd(event.start));
				$("#hv").html(event.heure);
				$('#myModal').modal('show');
			},
		});
  
  $("#saveVst").on('click',function(){
	  	var datee = $("#dv").html();
	  	var heure = $("#hv").html();
	  	var observation = $("#obs").val();
		
	  	$.ajax({
			type: "GET",
            url: "addVisite",
            data : {datee:datee,heure:heure,observation:observation},
            success: function (data) {
            	var obj = JSON.parse(data);
            	if (obj.res=="succ")
            	{
            		$('#myModal').modal('toggle');
            		$('#calendar').fullCalendar('refetchEvents');
            	}
            }
		});
	  	
	  	
  });
  
});


</script>