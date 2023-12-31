<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Pending Invoice</title>

    <link href="${pageContext.request.contextPath}/app-assets/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link  href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/app-assets/css/sb-admin-2.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
    <link href="${pageContext.request.contextPath}/app-assets/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
    
    <style type="text/css">
    
    .bg-light-danger {
		  background-color: #f5a2aa !important;
		}
		
    </style>

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <jsp:include page="../sidebar.jsp"></jsp:include>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <jsp:include page="../header.jsp"></jsp:include>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">
                    <!-- DataTales Example -->
                    <!-- <div class="d-sm-flex align-items-right justify-content-end mb-4">
                        <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                                class="fas fa-download fa-sm text-white-50 ml-2"></i>Validate</a>
                        <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm ml-2"><i
                                class="fas fa-download fa-sm text-white-50"></i>Prepare JSON</a>
                    </div> -->
                    <div class="row">
	                    <div class="form-group col-4">
	                        <input type="text" class="form-control form-control-user" id="fromDate" placeholder="From Date">
	                    </div>
	                 </div>
                    <div class="card shadow mb-4" id="pendingInvoiceDiv">
                    	
                        <div class="card-header py-3">
                        <div class="float-right">
                            <button type="button" class="btn btn-primary d-sm-inline-block" onclick="downloadMultipleJson()">Download</button>
                        </div>
                            <h6 class="m-0 font-weight-bold text-primary">Pending Invoice</h6>
                            
                        </div>
                        
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered display select" id="invoiceDataTable" width="100%" cellspacing="0">
<!--                                 <tr> -->
<!-- 											<th><input name="select_all" value="1" id="select-all" type="checkbox" /></th> -->
<!-- 											<th>Invoice No</th> -->
<!-- 											<th>Invoice Type</th> -->
<!-- 											<th>Invoice Date</th> -->
<!-- 											<th>Customer Name</th> -->
<!-- 											<th>Customer GST No</th> -->
<!-- 											<th>Invoice Amount</th> -->
<!-- 										</tr> -->
                                </table>
                            </div>
                        </div>
                    </div>
                    
                    <div class="card shadow mb-4" id="pendingInvoiceLineDiv" style="display:none;">
                        <div class="card-header py-3 d-sm-flex align-items-end justify-content-between mb-4">
                            <h6 class="font-weight-bold  text-primary">Pending Invoice Details</h6>
                            <div class="d-sm-inline-block">
	                            <button type="button" onclick="downloadMultipleJson()" id="downloadJSON" class="btn btn-primary">Download</button>
	         					<button type="button" class="btn btn-danger d-sm-inline-block" data-dismiss="modal" onclick="closeInvoiceDetailsDiv()">Close</button>
         					</div>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="invoiceDetailDataTable" width="100%" cellspacing="0">
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <jsp:include page="../footer.jsp"></jsp:include>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->



    <script src="${pageContext.request.contextPath}/app-assets/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendor/jquery-easing/jquery.easing.min.js"></script>
    <script src="${pageContext.request.contextPath}/app-assets/js/sb-admin-2.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
   	<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="${pageContext.request.contextPath}/app-assets/vendor/datatables/dataTables.bootstrap4.min.js"></script>
    <script src="${pageContext.request.contextPath}/script/pendingInvoice.js"></script>

</body>

</html>