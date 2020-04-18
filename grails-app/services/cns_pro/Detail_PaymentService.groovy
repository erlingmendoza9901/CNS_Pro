package cns_pro

import grails.gorm.services.Service

@Service(Detail_Payment)
interface Detail_PaymentService {

    Detail_Payment get(Serializable id)

    List<Detail_Payment> list(Map args)

    Long count()

    void delete(Serializable id)

    Detail_Payment save(Detail_Payment detail_Payment)

}