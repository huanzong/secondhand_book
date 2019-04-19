package com.hq.secondhand_book.service.serviceimpl;

import com.hq.secondhand_book.entity.PlaceTransaction;
import com.hq.secondhand_book.repository.PlaceTransactionRepository;
import com.hq.secondhand_book.service.PlaceTransactionService;
import com.hq.secondhand_book.util.resp.Response;
import com.hq.secondhand_book.util.resp.ResultResp;
import com.hq.secondhand_book.vo.PlaceTransactionVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlaceTransactionServiceImpl implements PlaceTransactionService {
    @Resource
    PlaceTransactionRepository placeTransactionRepository;

    /**
     * 获取交易地点
     * @return
     */
    @Override
    public ResultResp getPlace() {
        List<PlaceTransaction> list = placeTransactionRepository.findAll();
        List<PlaceTransactionVo> vos = new ArrayList<>();
        if(!list.isEmpty()){
            for(PlaceTransaction placeTransaction:list){
                PlaceTransactionVo vo=new PlaceTransactionVo();
                vo.setPlaceFatherId(placeTransaction.getPlaceFatherId());
                vo.setPlaceName(placeTransaction.getPlaceName());
                vo.setPlaceLevel(placeTransaction.getPlaceLevel());
                vo.setPlaceTransactionId(placeTransaction.getId());
                vos.add(vo);
            }
        }
        return Response.ok(vos);
    }
}
