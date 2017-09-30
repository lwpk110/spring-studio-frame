package cn.spring.studio.service;

import cn.spring.studio.data.domain.TeamMember;
import cn.spring.studio.data.repository.TeamMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * Created by ernest on 2017/9/30.
 */
@Service
public class TeamMemberServiceImpl extends EntityServiceSupport<TeamMember,Long,TeamMemberRepository> implements  TeamMemberService {
    @Autowired
    protected TeamMemberServiceImpl(TeamMemberRepository repository) {
        super(repository);
    }
}
