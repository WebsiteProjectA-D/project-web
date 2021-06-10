    <div class="card">
        <div class="card-header">
          <h3 class="card-title">Projects</h3>

          <div class="card-tools">
            <button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse">
              <i class="fas fa-minus"></i></button>
            <button type="button" class="btn btn-tool" data-card-widget="remove" data-toggle="tooltip" title="Remove">
              <i class="fas fa-times"></i></button>
          </div>
        </div>
        <div class="card-body p-0">
          <table class="table table-striped projects" id="vispati">
              <thead>
                  <tr>
                      <th style="width: 1%">
                          #
                      </th>
                      <th style="width: 20%">
                          Visite
                      </th>
                      
                      
                      <th style="width: 8%" class="text-center">
                          Observation
                      </th>
                      <th style="width: 20%">
                      </th>
                  </tr>
              </thead>
              <tbody>
               
              
              </tbody>
          </table>
        </div>
        <!-- /.card-body -->
      </div>
      
      
      <div class="modal fade" id="modalOrd" style="width: 100%;">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Ordonnance</h4>
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
						<input type="hidden" class="form-control" id="idr"/>
						
							<div class="card-body">
							<input type="button" value="+" id="sb" class="btn btn-primary">
							<h3></h3>
								<div id="inp" >
								</div>
							</div>



						</form>
					</div>
				</div>

				<div class="modal-footer justify-content-between">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary" id="saveOrd">Create</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
      
 <script>
 
 	
 	function verif(idv)
 	{
 		var x = "";
 		/*var string2 = "<a class='btn btn-primary btn-sm' href='#' onclick='aff("+idv+")'><i class='fas fa-folder'> </i>create</a>";
 		var x1="";*/
 				
 		$.ajax({
			type: "GET",
			'async': false,
            url: "VerifOrd",
             data : {idv:idv},
            success: function (data) {
            	var obj = JSON.parse(data);
            	if(obj.res=="1")
            	{
            		x = "<a class='btn btn-primary btn-sm' href='GenerOrd?idv="+idv+"' target='_blank'><i class='fas fa-folder'> </i>view</a>";
            	}
            	else
            		{
            			x = "<a class='btn btn-primary btn-sm' href='#' onclick='aff("+idv+")'><i class='fas fa-folder'> </i>create</a>";
            		}
            		
            			
            }
		});
 			return x;	
 	}
 	
 	$('#modalOrd').on('hidden.bs.modal', function () {
 		 	$("#inp").html();
 		});
 	
 	function aff(x)
 	{
 		$.ajax({
			type: "GET",
			'async': false,
            url: "VerifOrd",
             data : {idv:x},
            success: function (data) {
            	var obj = JSON.parse(data);
            	if(obj.res=="1")
            	{
            		
            	}
            	else
            		{
            			$("#idr").val(x);
            			$("#modalOrd").modal("show");
            			
            			
            		}
            		
            }
		});
 	}
	 
	 (function(window, location) {
		    history.replaceState(null, document.title, location.pathname+"#!/stealingyourhistory");
		    history.pushState(null, document.title, location.pathname);

		    window.addEventListener("popstate", function() {
		      if(location.hash === "#!/stealingyourhistory") {
		            history.replaceState(null, document.title, location.pathname);
		            setTimeout(function(){
		            	$("#contain").load("patients.jsp");
		                $("#tit").html("");
		                $("#tit").html("liste des patients");
		            },0);
		      }
		    }, false);
		}(window, location));

	 	var cinp = $("#cindp").val();
		
		
		$.ajax({
				type: "GET",
	            url: "visiteByPatient",
	             data : {cinp:cinp},
	            success: function (datas) {
	            	$("#vispati tbody").html("");
	            	for(var i=0;i<datas.length;i++){
	     	    	   var ligne=$("<tr></tr>");
	     	    	   ligne.append("<td>#</td>");   
	     	    	   ligne.append("<td><a>Visite "+(i+1)+"</a><br/><small>Date : "+datas[i].date+"</small></td>");
	     	    	   ligne.append("<td class='project-state'><span>"+datas[i].observation+"</span></td>");
	     	    	   ligne.append("<td class='project-actions text-right'>"+verif(datas[i].id)+"</td>");
	     	           $("#vispati tbody").append(ligne);
	     	           }
	            }
			});
		
		var i=1;
		$("#sb").click(function(){ 
			var htmlc = " <div class='row' id='d"+i+"'> " +
						" <div class='form-group col-md-5'> " +
						"<select id='s"+(i)+"' class='form-control lstm' style='width: 100%;'></select> </div>"+
						" <div class='form-group col-md-3'>" +
						"<input type='text' class='form-control qt' placeholder='quantité' > </div>"+
						" <div class='form-group col-md-3'>" +
						"<input type='text' class='form-control dr' placeholder='duration'> </div>"+
						" <div class='form-group col-md-1'>" +
						"<input type='button' class='btn btn-danger tt' value='-' id='sup"+i+"'>  " +
						" </div> </div>";
			$("#inp").append(htmlc);
			
			$.ajax({
				type: "GET",
	            url: "getAllmedc",
	            success: function (datas) {
	            	$(".lstm").select2("");
	            	for (var c = 0; c < datas.length; c++) {
	                   $(".lstm").append('<option value="' + datas[c].id + '">' + datas[c].nom + '</option>');
	                   
	                }
	            	
	            }
	            
			});
			i++;
			});
		
		$("#inp").on('click','.tt',function(){
			var id = $(this).attr('id');
			var n=id.substring(3);
			var x2="#d"+n;
			$(x2).remove();
		});
		
		function afficher()
		{
			var cinp = $("#cindp").val();
			
			$.ajax({
				type: "GET",
	            url: "visiteByPatient",
	             data : {cinp:cinp},
	            success: function (datas) {
	            	$("#vispati tbody").html("");
	            	for(var i=0;i<datas.length;i++){
	     	    	   var ligne=$("<tr></tr>");
	     	    	   ligne.append("<td>#</td>");   
	     	    	   ligne.append("<td><a>Visite "+(i+1)+"</a><br/><small>Date : "+datas[i].date+"</small></td>");
	     	    	   ligne.append("<td class='project-state'><span>"+datas[i].observation+"</span></td>");
	     	    	   ligne.append("<td class='project-actions text-right'>"+verif(datas[i].id)+"</td>");
	     	           $("#vispati tbody").append(ligne);
	     	           }
	            }
			});
		}
		
		$("#saveOrd").on('click',function(){
			
			var tabMed = [];
			var tabQt = [];
			var tabDr = [];
			var idVisite = $("#idr").val();
			
		    $('.lstm  option:selected').each(function() {
		        tabMed.push($(this).val());
		    });
		    
		    $(".qt").each(function() {
		       tabQt.push($(this).val());
		    });
		    
		    $(".dr").each(function() {
			       tabDr.push($(this).val());
			    });
		    
		    $.ajax({
				type: "GET",
	            url: "CreateOrd",
	            data : {tabMed:tabMed,tabQt:tabQt,tabDr:tabDr,idVisite:idVisite},
	            success: function (data) {
	            	var obj = JSON.parse(data);
	            	if(obj.res=="succ")
	            	{
	            		$("#modalOrd").modal("toggle");
	            		afficher();
	            		toastr.success('Ordonnance crée')
	            		
	            	}
	            	
	            }
	            
			});
		});
		
		
	 
	 
 </script>