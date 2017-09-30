package cn.spring.studio.data.repository;

import cn.spring.studio.data.domain.TeamMember;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * {@inheritDoc}
 *
 * Created by ernest on 2017/5/18.
 */
public interface TeamMemberRepository extends PagingAndSortingRepository<TeamMember, Long> {
}
