package com.hq.secondhand_book.service.serviceimpl;

import com.hq.secondhand_book.entity.ReceivingAddress;
import com.hq.secondhand_book.entity.User;
import com.hq.secondhand_book.repository.PlaceTransactionRepository;
import com.hq.secondhand_book.repository.ReceivingAddressRepository;
import com.hq.secondhand_book.repository.UserRepositiry;
import com.hq.secondhand_book.service.ReceiveAdressService;
import com.hq.secondhand_book.util.Constant;
import com.hq.secondhand_book.util.resp.Response;
import com.hq.secondhand_book.util.resp.ResultResp;
import com.hq.secondhand_book.vo.ReceiveAddressVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReceiveAdressServiceImpl implements ReceiveAdressService {
    @Resource
    UserRepositiry userRepositiry;
    @Resource
    ReceivingAddressRepository receivingAddressRepository;

    @Override
    public ResultResp getRececiveAdress(String userName) {
        List<ReceiveAddressVo> receiveAddressVos = new ArrayList<>();
        User user = userRepositiry.findByUserName(userName);
        if( user!= null){
            int userId = user.getId();
            List<ReceivingAddress> list = receivingAddressRepository.getByUserIdAndUsable(userId,Constant.USABLE);
            if(!list.isEmpty()){
                for(ReceivingAddress address:list){
                    ReceiveAddressVo vo=new ReceiveAddressVo();
                    vo.setPlaceName(address.getPlaceName());
                    vo.setReceiverName(address.getReceiverName());
                    vo.setReceiverTel(address.getReceiverTel());
                    vo.setIsDefault(address.getIsDefault());
                    receiveAddressVos.add(vo);
                }
            }
        }
        return Response.ok(receiveAddressVos);
    }
}
