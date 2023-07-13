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
			{ data: null, className: 'dt-center', render: jsonPrepareFormatter },
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


function jsonPrepareFormatter(cellvalue, options, rowObject) {
	return "<a onclick='downloadJsonByInvoice(\"" + rowObject.salesInvoiceId + "\",\"" + rowObject.salesInvoiceNo + "\");' title='JSON Prepare' href='javascript:void(0)' class='btn btn-sm btn-light-info btn-hover-light-info btn-icon mr-2 my-1 my-lg-0' > <i class='fa fa-download'></i></a>";
}

function downloadJsonByInvoice(salesInvoiceId,salesInvoiceNo){
	var link = document.createElement('a');
	link.href = "getPrepareJsonFileInvoice?salesInvoiceId="+salesInvoiceId+"&salesInvoiceNo="+salesInvoiceNo;
	document.body.appendChild(link);
	link.click();
}
