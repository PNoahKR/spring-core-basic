package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDicountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceIpml;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memeberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceIpml(memeberRepository(), discountPolicy());
    }

    public MemberRepository memeberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDicountPolicy();
    }
}
