$('document').ready(function(){

 getPendingInvoiceList();

});

function getPendingInvoiceList() {
	$('#invoiceDataTable').DataTable({
		ordering: false,
		destroy: true,
		searching: true,
		scrollY: true,
		scrollX: true,
		scrollCollapse: true,
		processing: true,
		serverSide: true,
		deferRender: true,
//		lengthMenu: [5, 10, 25, 50],
		ajax: {

			url: 'getPendingInvoiceList' ,

			// parameters for custom backend script demo
			columnsDef: ['SalesInvoiceId', 'SalesInvoiceNo', 'SalesInvoiceDate'],
		},
		columns: [
			{ title: 'Id', data: 'salesInvoiceId' },
			{ title: 'Invoice No', data: 'salesInvoiceNo' },
			{ title: 'Invoice Date', data: 'salesInvoiceDate' },
//			{ data: null, className: 'dt-center', render: potentialConnectionFormatter },
		],
		fixedColumns: {
			rightColumns: 1,
			leftColumns: 0
		}, createdRow: function(row, data, dataIndex) {
			//			if (data.status == 'New')  {
			//				$('td', row).addClass('dataTableColorClass');
			//			}
		}
	});
}


function potentialConnectionFormatter(cellvalue, options, rowObject) {
	return "<a onclick='addUpdateConnection(\"" + rowObject.userId + "\",\"" + rowObject.userType + "\", 4, 4);' title='Block' href='javascript:void(0)'class='btn btn-sm btn-light-danger btn-hover-light-danger btn-icon mr-2 my-1 my-lg-0' > <i class='icon-md fas fa-user-lock'></i></a>" + "<a onclick='addUpdateConnection(\"" + rowObject.userId + "\",\"" + rowObject.userType + "\", 2, 3);' title='Add' href='javascript:void(0)'class='btn btn-sm btn-light-success btn-hover-light-success btn-icon mr-2 my-1 my-lg-0' > <i class='icon-md fas fa-user-plus'></i></a>";
}