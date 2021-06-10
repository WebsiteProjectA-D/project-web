
<div class="row">
          <!-- left column -->
          <div class="col-md-6">
            <!-- general form elements -->
            <div class="card card-primary">
              <div class="card-header">
                <h3 class="card-title">Region</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form role="form" class="col-md-6">
              <input type="hidden" class="form-control" id="idReg" value="0">
                <div class="card-body">
                  <div class="form-group">
                    <label for="exampleInputEmail1">Region</label>
                    <input type="text" class="form-control" id="nomReg" placeholder="region">
                  </div>
                  <p class="form-group">
                  <button type="button" class="btn btn-primary" id="saveReg">Enregister</button>
                  <button type="button" class="btn btn-primary" id="vidReg">vider</button>
                </p>
                </div>
					
              </form>
            </div>
          </div>
        </div>		
        
        <div class="row">
          <!-- left column -->
          <div class="col-md-6">
            <!-- general form elements -->
            <div class="card card-primary">
              <div class="card-header">
                <h3 class="card-title">Region</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form role="form">
                <div class="card-body">
                  		<table id="listRegion" class="table table-bordered">
							<thead>
								<tr>
									<th>Id</th>
									<th>Nom</th>
								</tr>
							</thead>
						</table>
                </div>
					
              </form>
            </div>
          </div>
        </div>		
<script src=js/Region.js></script>