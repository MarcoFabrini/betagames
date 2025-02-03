package com.betagames.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.betagames.dto.OrdersDTO;
import com.betagames.request.OrdersRequest;
import com.betagames.response.ResponseBase;
import com.betagames.response.ResponseList;
import com.betagames.service.interfaces.IOrdersService;

/*
 * 
 * @author Simone Checco
 */

@RestController
@RequestMapping("/rest/orders")
public class OrdersController {
    
    @Autowired
    private IOrdersService ordersService;

    @GetMapping("/allOrders")
    public ResponseList<OrdersDTO> listOrders() {
        ResponseList<OrdersDTO> responseList = new ResponseList<OrdersDTO>();
        responseList.setRc(true);

        try {
            responseList.setData(ordersService.findAllOrders());
        } catch (Exception e) {
            responseList.setRc(false);
            responseList.setMsg(e.getMessage());
        }

        return responseList;
    }
    

    @GetMapping("/userOrders")
    public ResponseList<OrdersDTO> listOrdersByUsers(Integer id){
        ResponseList<OrdersDTO> listResponse = new ResponseList<OrdersDTO>();
        listResponse.setRc(true);

        try {
            listResponse.setData(ordersService.findByUser(id));
        } catch (Exception e) {
            listResponse.setRc(false);
            listResponse.setMsg(e.getMessage());
        }
        listResponse.setMsg("lista scaricata con successo");

        return listResponse;
    }

    @PostMapping("/createOrders")
    public ResponseBase create(@RequestBody(required = true) OrdersRequest req){
        ResponseBase response = new ResponseBase();
        response.setRc(true);
        response.setMsg("Ordine Creato con successo");
        try {
            ordersService.create(req);
        } catch (Exception e) {
            response.setRc(false);
            response.setMsg(e.getMessage());
        }
        

        return response;
    }
    @PostMapping("/updateOrders")
    public ResponseBase update(@RequestBody (required = true) OrdersRequest req) {
        ResponseBase response = new ResponseBase();
        response.setRc(true);
        response.setMsg("Ordine Aggiornato con successo");
        try {
            ordersService.update(req);
        } catch (Exception e) {
            response.setRc(false);
            response.setMsg(e.getMessage());
        }
        
        return response;
    }

    @PostMapping("/deleteOrders")
    public ResponseBase delete(@RequestBody (required = true) OrdersRequest req) {
        ResponseBase response = new ResponseBase();
        response.setRc(true);
        response.setMsg("Ordine eliminato con successo");
        try {
            ordersService.delete(req);
        } catch (Exception e) {
            response.setRc(false);
            response.setMsg(e.getMessage());
        }
        
        return response;
    }
    
}
