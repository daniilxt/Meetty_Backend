package com.daniilxt.meetty.entity

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.*

@Entity
@Table(name = "user_credentials")
class UserDetailEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val login: String,
    @Column(name = "password")
    val userPassword: String,
    @OneToOne
    @JoinColumn(name = "user_id")
    val user: UserEntity
) : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return AuthorityUtils.NO_AUTHORITIES
    }

    override fun getPassword() = userPassword
    override fun getUsername() = login

    override fun isAccountNonExpired() = true
    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true

}